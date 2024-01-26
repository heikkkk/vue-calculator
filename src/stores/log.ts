import { defineStore } from 'pinia'
import { reactive } from 'vue'

export interface loggedExpression {
    id: number
    expression: string
    ans: string
};

export const useLogStore = defineStore('log', () => {

    const log: loggedExpression[] = reactive([])

    function addToLog(expression: string, ans: string) {
        const idNum = log.length
        const loggedExpression = {id: idNum, expression: expression, ans: ans}
        log.push(loggedExpression)
    }

    function getAns() {
        if (log.length > 0) return log[log.length-1].ans
    }

    return { log, addToLog, getAns }
})