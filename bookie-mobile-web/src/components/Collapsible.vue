<template>

    <div class="bg-white border-2 border-round-lg border-gray-400">
        <Button class="text-black-alpha-60 w-full bg-gray-400 border-none" :icon="'pi pi-'+(visible ? 'minus':'plus')" :label="props.header"
            @click="visible = !visible"></Button>
        <div class="card" v-if="visible">
            <slot name="content" />
        </div>
    </div>

</template>
<script setup>
import { ref } from 'vue';

const props = defineProps({
    header: {
        type: String
    },
    collapsed: {
        type: Boolean,
        default: true
    }

})


const visible = ref(!props.collapsed)

</script>