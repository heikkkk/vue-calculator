<template>
    <div class="numpad">
        <div 
            v-for="number in requiredButtons"
            :key="number.indexOf"
            class="button"
            :columns="columns"
            :rows="rows"
        >
            <BaseButton 
                :value="number"
                @updateExpression="$emit('updateExpression', $event)"
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
            row: 'repeat(' + this.row + ', 1fr)',
        }
    },
    computed: {
        requiredButtons() {
            var buttons = this.numbers
            var gridSize = (this.rows)*(this.columns)
            var sizeNumbers = this.numbers.length

            if (sizeNumbers < gridSize) {
                var diff = gridSize-sizeNumbers
                for (let i = 0; i < diff; i++) {
                    buttons.push('')
                }
            }
            return buttons
        }
    },
    emits: [ 'updateExpression' ]
}

</script>

<style scoped>
.numpad {
  display: grid;
  grid-template-columns: v-bind(column);
  grid-template-rows: v-bind(row);
  width: v-bind((columns*64) + 'px');
  margin-left: 8px;
}

.button {
  text-align: center;
  max-width: 64;
  max-height: 50;
}
</style>
