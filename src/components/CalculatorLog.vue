<template>
    <div>
        <ul 
            v-for="item in log.slice().reverse()"
            :key="item.id"
        >
            <li>{{ item.expression }} = {{ item.ans }}</li>
        </ul>
    </div>

</template>

<script setup lang="ts">
import { useLogStore} from '@/stores/log'
const logStore = useLogStore()
const log = logStore.log

</script>

