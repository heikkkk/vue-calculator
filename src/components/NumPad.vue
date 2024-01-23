<template>
    <div class="test"></div>
    <div class="numpad">
        <div 
            v-for="number in numbers"
            :key="number.indexOf"
            class="button"
            :columns="columns"
            :rows="rows"
        >
        <BaseButton
            :value="number"
        />
        </div>
    </div>
</template>

<script lang="ts">
import type { PropType } from 'vue';
import BaseButton from '../components/BaseButton.vue'

export default {
    props: {
        numbers: {
            type: Array as PropType<string[]>,
            required: true
        },
        columns: {
            type: Number,
            default: 3
        },
        rows: {
            type: Number,
            default: 3
        }
    },
    components: { BaseButton },
    data () {
        return {
            column: 'repeat(' + this.columns +', 1fr)',
            row: 'repeat(' + this.row + ', 1fr)'
        }
    },
    methods: {
        calculateRequiredButtons: function() {
            var gridSize = this.rows*this.columns
            console.log(gridSize)
        }
    }
}

</script>

<style scoped>
.numpad {
  display: grid;
  grid-template-columns: v-bind(column);
  grid-template-rows: v-bind(row);
  gap: 8px;
}

.button {
  text-align: center;
}

</style>
