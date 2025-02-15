<template>

  <div class="w-full p-0 m-0">
    <div class="flex mt-4 justify-items-center align-items-center flex-wrap p-fluid">
      <div class="col">
        <div class="flex ml-auto mr-auto field justify-content-center align-items-center w-full">
          <label class="text-gray-500 mr-3 font-bold">{{ 'Usluga' }}</label>
          <Dropdown class="w-full  max-w-17rem" :options="services" optionLabel="name" v-model="selectedService" showClear>
          </Dropdown>
        </div>
      </div>
    </div>
    <BlockUI :blocked="resourcesLoading" class=" flex justify-content-center align-items-center ml-auto mr-auto">
      <div class="scrolling-wrapper scrolling-wrapper-flexbox" :style="{height:'70vh'}" v-if="workers">
        <div v-for="worker in workers.concat(workers).concat(workers)">
          <Card @click="showSidebar(worker.resource)" 
          class="h-10rem w-20rem shadow-5 mt-1 cursor-pointer border-indigo-500 border-2 border-round-md">
            <template #subtitle>
              <span class="font-bold">{{ worker.resource.name }}</span>
            </template>
            <template #content>
              <div class="flex flex-row items-start gap-2">
                <img src="/images/picture-barber.png" width="100" />
                <div class="col">
                  <span class="font-semibold">{{ worker.price + 'din' }}</span>
                </div>
              </div>
            </template>
          </Card>
        </div>

      </div>
    </BlockUI>
  </div>
  <Sidebar v-model:visible="sidebarVisible" position="right" class="w-full max-w-30rem bg-gray-200">
    <div class="w-full flex p-fluid flex-column formgrid grid">
      <label class="ml-auto mr-auto text-2xl font-bold">{{ selectedResource.name }}</label>
    </div>
    <Panel class="mt-3">
      <template #header>
        <div class="flex-wrap flex align-items-stretch w-full">
          <div class="flex flex-column w-full border-round">
            <div class="w-full flex align-items-center  justify-content-start">
              <label class="font-bold">{{ currentMonth }}</label>
              <label class="font-bold ml-3">{{ currentYear }}</label>
              <div class="ml-auto">
                <i id="arrow" class="text-3xl text-indigo-500  pi pi-angle-left hover:surface-200 mr-2"
                  @click="previousWeek"></i>
                <i id="arrow" class="ml-2 text-3xl text-indigo-500 pi pi-angle-right hover:surface-200"
                  @click="nextWeek"></i>
              </div>
            </div>

            <div class="flex-wrap flex align-items-stretch align-items-center mt-2">
              <div v-for="date in listOfDates" @click="dateSelected(date)" :style="{ width: '13%' }"
                class="cursor-pointer ml-auto align-items-center  flex date hover:surface-200 font-bold flex align-self-stretch flex-column mr-auto">
                <div v-if="date.value.getTime() / 1000 == selectedDate.value.getTime() / 1000"
                  class="bg-primary shadow-5 p-1 border-round mb-1">
                  <div class="font-bold text-center p-2 ">{{ date.dayName }}</div>
                  <div class="font-bold text-center mb-1">{{ date.dayInMonth }}</div>
                </div>
                <div v-if="date.value.getTime() / 1000 != selectedDate.value.getTime() / 1000"
                  class="p-1 border-round mb-2">
                  <div class="font-bold text-center border-round p-2">{{ date.dayName }}</div>
                  <div class="font-bold text-center border-round ">{{ date.dayInMonth }}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>
      <BlockUI :blocked="scheduleLoading">
        <div class="inline flex flex-wrap align-items-center  justify-content-start w-full border-round">
          <div v-for="calendarItemAllocation in calendarItemAllocations"
            class="mt-2 w-4rem date hover:surface-200 flex align-items-center justify-content-center border-round flex-column ml-5">
            <div class="text-center border-round border-1 p-2" @click="selectedTime = calendarItemAllocation.startedAt"
              v-bind:class="(calendarItemAllocation.busy ? 'surface-200 text-gray-400' : '')">{{
                useDateFormat(calendarItemAllocation.startedAt, 'HH:mm') }}</div>
          </div>
        </div>
      </BlockUI>
    </Panel>
    <Button class="w-full border-round bg-indigo-500" :label="'Zakazi'" @click="confirmDialogVisible = true"></Button>
  </Sidebar>

  <Dialog v-model:visible="confirmDialogVisible" modal="true" class="w-full max-w-30rem">
    <template #header>
      <div class="inline-flex items-center justify-center gap-2">
        <span class="font-bold whitespace-nowrap">{{ useDateFormat(selectedTime, 'HH:mm') }}</span>
      </div>
    </template>
    {{ 'Potvrda termina' }}
    <template #footer>
      <Button label="Otkaži" text severity="secondary" class="text-indigo-500" @click="confirmDialogVisible = false" />
      <Button label="Potvrdi" text severity="secondary" class="text-indigo-500" @click="insertReservation" />
    </template>
  </Dialog>


</template>
<script setup>
import { onMounted, ref, watch } from 'vue';
import axios from 'axios';
import { useDateFormat } from '@vueuse/core';
import { useToast } from 'primevue/usetoast';

const toast = useToast();

const listOfDates = ref(getListOfDatesInAWeek(new Date()));
const currentMonth = ref(getMonthName(listOfDates.value[6].value));
const currentYear = ref(getYear(listOfDates.value[6].value));

const sidebarVisible = ref(false)

const selectedDate = ref();
const selectedInterval = ref();
const calendarItemAllocations = ref([])
const workers = ref();

const services = ref();

const confirmDialogVisible = ref(false)

const selectedService = ref();
const resourcesLoading = ref(false);
const selectedResource = ref();
const selectedTime = ref();

watch(selectedService, async (newValue, oldValue) => {
  resourcesLoading.value = true;
  const response = await axios({
    method: 'post',
    url: '/api/ResourceService/findOptionsByWorkingUnitAndType',
    data: {
      workingUnit: 1,
      type: selectedService.value
    }
  });
  workers.value = response.data;
  resourcesLoading.value = false;
});

async function showSidebar(resource) {
  sidebarVisible.value = true
  selectedResource.value = resource;
  scheduleLoading.value = true;
  selectedDate.value = listOfDates.value.filter(date => date.value.getDay() === new Date().getDay())[0]
  const response = await axios({
    method: 'post',
    url: '/api/ResourceCalendarService/findResourceScheduleForDate',
    data: {
      date: selectedDate.value.value,
      resource: selectedResource.value.id,
      reservationType: selectedService.value
    }
  });
  calendarItemAllocations.value = response.data;
  scheduleLoading.value = false;
}

onMounted(async () => {

  const response = await axios({
    method: 'post',
    url: '/api/ReservationTypeService/findAll',
    data: {}
  });
  services.value = response.data;
})

const scheduleLoading = ref(false)
async function dateSelected(date) {
  selectedDate.value = date;

  scheduleLoading.value = true;
  console.log(selectedDate.value)
  const response = await axios({
    method: 'post',
    url: '/api/ResourceCalendarService/findResourceScheduleForDate',
    data: {
      date: selectedDate.value.value,
      resource: selectedResource.value.id,
      reservationType: selectedService.value
    }
  });
  scheduleLoading.value = false;
  calendarItemAllocations.value = response.data;

}

async function insertReservation() {
  const response = await axios({
    method: 'post',
    url: '/api/ReservationService/insert',
    data: {
      reservation: {
        type: selectedService.value,
        resource: selectedResource.value.id,
        dateTime: selectedTime.value,
        workingUnit: 1,
        customer: 1
      }
    }
  });
  toast.add("Succees")
  confirmDialogVisible.value = false;
  dateSelected(selectedTime.value)
  calendarItemAllocations.value = response.data;
}

function getMonthName(date) {
  return firstLetterToUpper(date.toLocaleString('sr-Latn-RS', { month: 'long' }))
}

function getYear(date) {
  return date.getFullYear();
}

function nextWeek() {
  var targetDate = new Date(listOfDates.value[6].value.getTime() + 1000 * 60 * 60 * 26);
  listOfDates.value = getListOfDatesInAWeek(targetDate);
  currentMonth.value = getMonthName(listOfDates.value[6].value);
  currentYear.value = getYear(listOfDates.value[6].value);
}

function previousWeek() {
  var targetDate = new Date(listOfDates.value[0].value.getTime() - 1000 * 60 * 60 * 24);
  console.log(targetDate)
  listOfDates.value = getListOfDatesInAWeek(targetDate);
  currentMonth.value = getMonthName(listOfDates.value[6].value);
  currentYear.value = getYear(listOfDates.value[6].value);
}

function getListOfDatesInAWeek(date) {
  var result = [];

  var firstDay = getPreviousMonday(date);

  result.push({ dayName: firstDay.toLocaleDateString('sr-Latn-RS', { weekday: 'short' }), dayInMonth: firstDay.getDate(), value: firstDay })

  for (let i = 1; i <= 6; i++) {
    var nextDay = new Date();
    nextDay.setTime(firstDay.getTime() + 1000 * 60 * 60 * 24 * i);
    result.push({ dayName: nextDay.toLocaleDateString('sr-Latn-RS', { weekday: 'short' }), dayInMonth: nextDay.getDate(), value: nextDay })
  }
  return result;
}
function getPreviousMonday(date) {
  var prevMonday = date;
  prevMonday.setDate(prevMonday.getDate() - (prevMonday.getDay() + 6) % 7);
  prevMonday.setHours(0)
  prevMonday.setMinutes(0);
  prevMonday.setSeconds(0);
  prevMonday.setMilliseconds(1);
  return prevMonday;

}

function leftArrowClicked() {
  console.log('Left arrow clicked');
}


function firstLetterToUpper(text) {
  return text.charAt(0).toUpperCase()
    + text.slice(1)
}

</script>
<style scoped>
body {
  margin: 0;
}

.scrolling-wrapper-flexbox {
  /* display: flex; */
  flex-wrap: nowrap;
  overflow-y: auto;

  .card {
    flex: 0 0 auto;
  }
}

.scrolling-wrapper {
  -webkit-overflow-scrolling: touch;
}

.scrolling-wrapper {
  &::-webkit-scrollbar {
    display: none;
  }
}
</style>