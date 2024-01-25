<template>
    <ButtonGroup
        :numbers="numpad"
        :rows="4"
        @updateExpression="console.log($event)"
    >
    </ButtonGroup>

    <ButtonGroup
        :numbers="operators"
        :columns="2"
        :rows="4"
        @updateExpression="console.log($event)"
    >
    </ButtonGroup>
</template>

<script lang="ts">
import ButtonGroup from '@/components/ButtonGroup.vue';
export default {
    data() {
        return {
            numpad: [
                '7',
                '8',
                '9',
                '4',
                '5',
                '6',
                '1',
                '2',
                '3',
                '.',
                '0',
            ],
            operators: [
                'DEL',
                'C',
                '*',
                '/',
                '+',
                '-',
                'ANS',
                '='
            ],
            expression: ''
            
        };
    },
    methods: {
        updateExpression(input: string) {
            this.expression.concat(input)
        },
        clearExpression() {
            this.expression = ''
        },
        popExpression() {
            let endChar = this.expression.length-1
            this.expression = this.expression.slice(0, endChar)
        },

        handleExpressionUpdate(event: string) {
            let input = event
            const numberRegex = /^-?\d*\.?\d+$/;
            const operatorRegex = /^[+\-*/]$/;

            if (numberRegex.test(input) || operatorRegex.test(input)) {
                //concat the event to expression
                //return from method
                this.updateExpression(input)
                return
            }
            this.checkSpecialOperator(input)
        },

        checkSpecialOperator(input: string) {
        switch (input) {
            case 'ANS':
                console.log('The input is equal to "ANS".');
                //run answer-function
                break;
            case 'C':
                console.log('The input is equal to "C".');
                //run clear-function
                this.clearExpression()
                break;
            case 'DEL':
                console.log('The input is equal to "DEL".');
                //delete last input of the expression
                this.popExpression
                break;
            case '=':
                console.log('The input is equal to "=".');
                //run equals-function
                break;
            default:
                //do noting?
                console.log('The input does not match any of the specified strings.');
            }
        }
    },
    components: { ButtonGroup }
}
</script>
