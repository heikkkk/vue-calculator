<template>
    <div class="container">
      <h1>Gi oss tilbakemelding</h1>
      <form @submit="submit">
        <FeedBackInput
          label="Navn"
          type="text"
          :error="errors.name"
          :modelValue="name"
          @change="handleChange"
        ></FeedBackInput>

        <FeedBackInput
          label="Epost"
          type="email"
          :error="errors.email"
          :modelValue="email"
          @change="handleChange"
        ></FeedBackInput>

        <FeedBackInput
          label="Melding"
          class="message"
          type="text"
          :error="errors.message"
          :modelValue="message"
          @change="handleChange"
        ></FeedBackInput>
        <button type="submit">Send inn</button>
      </form>
      <!--<pre>{{ feedback }}</pre>-->
    </div>
</template>

<script>
import FeedBackInput from '@/components/FeedbackInput.vue'
import { useField, useForm } from 'vee-validate'
import { useUserStore } from '@/stores/user'
import axios from 'axios'

export default {
  setup () {
    const required = value => {
      const requiredMessage = 'Dette feltet er påkrevd'
      if (value === undefined || value === null) return requiredMessage
        if (!String(value).length) return requiredMessage

        return true
    }

    const emailSyntax = value => {
      const emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          if (!emailRegex.test(String(value).toLowerCase())) {
            return 'Vennligst skriv inn en gyldig epost-adresse'
          }

          return true
    }

    const validationSchema = {
      name: required,
      email: value => {
        const req = required(value)
        if (req !== true) return req

        const emailCheck = emailSyntax(value)
        if (emailCheck !== true) return emailCheck

        return true
      },
      message: required
    }

    const { handleSubmit, errors, setFieldValue } = useForm({
      validationSchema,
      initialValues: {
        name: useUserStore().name,
        email: useUserStore().email
      }
    })

    const { value: name } = useField('name')
    const { value: email } = useField('email')
    const { value: message } = useField('message')

    const handleChange = (event) => {
      let field = ''
      if (event.target.id == 1) field = 'name'
      else if (event.target.id == 2) field = 'email'
      else if (event.target.id == 3) field = 'message'

      setFieldValue(field, event.target.value)
    }

    const submit = handleSubmit(values => {
      console.log('submit', values)
    })

    return {
      name,
      email,
      message,
      errors,
      handleChange,
      submit,
    }
  },
  components: {FeedBackInput}
}
    
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 100%;
}
.message {
  height: 120px;
}

button {
  outline: 0;
    grid-gap: 8px;
    align-items: center;
    background: 0 0;
    border: 1px solid #000;
    border-radius: 4px;
    cursor: pointer;
    display: inline-flex;
    flex-shrink: 0;
    font-size: 16px;
    gap: 8px;
    justify-content: center;
    line-height: 1.5;
    overflow: hidden;
    padding: 12px 16px;
    text-decoration: none;
    text-overflow: ellipsis;
    transition: all .14s ease-out;
    white-space: nowrap;
    background-color: aliceblue;
    height: 50px;
    width: 64px;
}

button:hover {
    box-shadow: 4px 4px 0 #000;
    transform: translate(-4px,-4px);
}



button:focus-visible {
    outline-offset: 1px;
}
</style>
