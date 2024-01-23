<template>
    <NumPad
        :numbers="numpad"
    >
    </NumPad>
</template>

<script lang="ts">
import NumPad from '@/components/NumPad.vue';
export default {
    data() {
        return {
            numpad: [
                '7',
                '6',
                '9',
                '4',
                '5',
                '6',
                '1',
                '2',
                '3',
                'DEL',
                '0',
                '.',
            ]
        };
    },
    components: { NumPad }
}
</script>
