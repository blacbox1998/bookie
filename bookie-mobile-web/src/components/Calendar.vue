<template>

    <div class="flex align-content-evenly flex-wrap">
        <div class="w-full flex align-items-center  justify-content-start flex-column">
            <Avatar icon="pi pi-user" class="ml-auto  text-indigo-500 mr-auto mr-2" size="xlarge" shape="circle" />
            <h2>{{ 'Marko Mitrovic' }}</h2>
        </div>
    </div>
    <Panel>
        <template #header>
            <div class="flex-wrap flex align-items-stretch w-full">
                <div class="flex flex-column w-full border-round">
                    <div class="w-full flex align-items-center  justify-content-start">
                        <label class="text-3xl font-bold">{{ currentMonth }}</label>
                        <div class="ml-auto">
                            <i id="arrow" class="text-5xl text-indigo-500  pi pi-angle-left hover:surface-200 mr-2"
                                @click="previousWeek"></i>
                            <i id="arrow" class="ml-2 text-5xl text-indigo-500 pi pi-angle-right hover:surface-200"
                                @click="nextWeek"></i>
                        </div>
                    </div>


                    <div class="flex-wrap flex align-items-stretch align-items-center">
                        <div v-for="date in listOfDates" @click="dateSelected(date)" :style="{ width: '13%'}"
                            class="ml-auto align-items-center  flex mt-3 mb-3 date hover:surface-200 font-bold flex align-self-stretch border-round flex-column mr-auto">
                            <div class="text-lg font-bold text-center border-round p-2">{{ date.dayName }}</div>
                            <div class="text-lg font-bold text-center border-round ">{{ date.dayInMonth }}</div>
                        </div>
                    </div>
                </div>
            </div>
        </template>
        <div class="inline flex flex-wrap align-items-center justify-content-start w-full">
            <div v-for="interval in timeIntervals"
                class="mt-3 w-4rem date hover:surface-200 flex align-items-center justify-content-center border-round flex-column ml-5">
                <div class="text-center border-round border-1 p-2"
                    v-bind:class="(interval.disabled ? 'surface-200 text-gray-400' : '')">{{ interval.label }}</div>
            </div>

        </div>
        <!-- <div class="flex align-items-center justify-content-start mt-3">

            <div v-for="interval in secondRow"
            class=" w-full date hover:surface-200 font-bold flex align-items-center justify-content-center border-round flex-column ml-5">
            <div class="block font-bold text-center border-round border-2 p-2">{{ interval.label }}</div>
            </div>

        </div> -->


    </Panel>
    <Button class="w-full border-round bg-indigo-500" :label="'Zakazi'"></Button>

</template>
<script setup>
import { ref } from 'vue'

const listOfDates = ref(getListOfDatesInAWeek(new Date()));
const currentMonth = ref(getMonthName(listOfDates.value[6].value));

const selectedDate = ref();
const selectedInterval = ref();
const timeIntervals = ref([
    { label: '08:00' },
    { label: '08:30', disabled: true },
    { label: '09:00' },
    { label: '09:30' },
    { label: '10:00' },
    { label: '10:30' },
    { label: '11:00' },
    { label: '11:30' },
    { label: '12:00' },
    { label: '12:30' },
    { label: '13:00' },
    { label: '13:30', disabled: true },
    { label: '14:00' },
    { label: '14:30' },
    { label: '15:00' },
    { label: '15:30' },
    { label: '16:00' },
]);

function dateSelected(date) {
    selectedDate.value = date
    console.log('Date selected', selectedDate.value)
}

function getMonthName(date) {
    return firstLetterToUpper(date.toLocaleString('sr-Latn-RS', { month: 'long' }))
}

function nextWeek() {
    var targetDate = new Date(listOfDates.value[6].value.getTime() + 1000 * 60 * 60 * 26);
    console.log(targetDate)
    listOfDates.value = getListOfDatesInAWeek(targetDate);
    currentMonth.value = getMonthName(listOfDates.value[6].value);
}

function previousWeek() {
    var targetDate = new Date(listOfDates.value[0].value.getTime() - 1000 * 60 * 60 * 24);
    console.log(targetDate)
    listOfDates.value = getListOfDatesInAWeek(targetDate);
    currentMonth.value = getMonthName(listOfDates.value[6].value);
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
<style>
i:hover {
    cursor: pointer;
}

.date:hover {
    cursor: pointer;
}
</style>