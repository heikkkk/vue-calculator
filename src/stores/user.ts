import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore('user', () => {
    const name = ref('')
    const email = ref('')

    function updateName(newName: string) {
        name.value = newName
    }
    function updateEmail(newEmail: string) {
        email.value = newEmail
    }

    return {name, email, updateEmail, updateName} 
})