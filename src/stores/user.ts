import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore('user', () => {
    const name = ref('')
    const email = ref('')

    function setName(newName: string) {
        name.value = newName
    }
    function setEmail(newEmail: string) {
        email.value = newEmail
    }

    return {name, email, setEmail, setName} 
})