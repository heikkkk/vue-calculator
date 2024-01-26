<template>
    <div class="calculator-container">
        <label class="error-label">{{ displayError }}</label>
        <CalculatorDisplay
            :expression="expression"
            @input-update="console.log($event)"
            class="calculator-display"
        ></CalculatorDisplay>
        <div class="button-groups">
            <ButtonGroup
                :numbers="numpad"
                :rows="4"
                @updateExpression="handleExpressionUpdate($event)"
            ></ButtonGroup>
            <ButtonGroup
                :numbers="operators"
                :columns="2"
                :rows="4"
                @updateExpression="handleExpressionUpdate($event)"
            ></ButtonGroup>
        </div>
    </div>
    <div>
        <CalculatorLog></CalculatorLog>
    </div>
</template>

<script lang="ts">
import ButtonGroup from '@/components/ButtonGroup.vue'
import CalculatorDisplay from '@/components/CalculatorDisplay.vue'
import CalculatorLog from '@/components/CalculatorLog.vue'
import { useLogStore } from '@/stores/log'

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
            expression: '',
            displayError: '',
        };
    },
    methods: {
        updateExpression(input: string) {
            this.expression = this.expression.concat(input)
            console.log(this.expression)
        },
        clearExpression() {
            this.expression = ''
        },
        popExpression() {
            const lastIndex = this.expression.length-1
            this.expression = this.expression.slice(0, lastIndex)
        },

        handleExpressionUpdate(event: string) {
            this.displayError = ''
            let input = event
            const numberRegex = /^-?\d*\.?\d+$/;
            const operatorRegex = /^[+\-*/.]$/;
            const lastIndex = this.expression.length-1
            const lastChar = this.expression.charAt(lastIndex)

            if (numberRegex.test(input)) {
                if(lastChar === '0' && (this.expression.length === 1 || operatorRegex.test(this.expression.charAt(lastIndex-1)))) {
                    this.popExpression()
                }
                this.updateExpression(input)
                return
            }
            if (operatorRegex.test(input)) {
                if (operatorRegex.test(lastChar)) {
                    this.popExpression()
                }
                this.updateExpression(input)
                return
            }
            this.checkSpecialOperator(input)
        },

        checkSpecialOperator(input: string) {
        switch (input) {
            case 'ANS':
                if (useLogStore().log.length > 0) {
                    this.expression = this.expression + useLogStore().getAns()
                }
                break;
            case 'C':
                this.clearExpression()
                break;
            case 'DEL':
                this.popExpression()
                break;
            case '=':
                this.evaluateExpression()
                break;
            default:
                //do noting?
            }
        },
        evaluateExpression() {
            let expressionCopy = this.expression
            const operatorRegex = /^[+\-*/.]$/;
            if(operatorRegex.test(expressionCopy.charAt(0))) {
                expressionCopy = '0'+expressionCopy 
            }

            const ans = eval(expressionCopy).toString()
            if(ans === 'NaN' || ans === 'Infinity') {
                this.expression = ''
                this.displayError = 'Ikkje del på null kamerat'
                return
            }
            useLogStore().addToLog(expressionCopy, ans)
            this.expression = ans
        }
    },
    components: { ButtonGroup, CalculatorDisplay, CalculatorLog }
}
</script>

<style scoped>
.calculator-container {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 100%;
}

.button-groups {
  display: flex;
  width: auto;
}

.calculator-display { /* Adjust the width to match the width of the ButtonGroups */
  margin-bottom: 10px; /* Add margin for spacing */
  width:100%;
  font-size: 16px;
}
.error-label {
  margin-right: 10px; /* Add right margin for spacing between label and other components */
  color: #ff3333;
  min-height: 30px;
}
</style>
