<script setup>
  import FeedBackInput from '@/components/FeedbackInput.vue'
  import { reactive } from 'vue'

  const feedback = reactive(
    {
      name: '',
      email: '',
      message: '',
      
    })

    function  onSubmit() {
      alert('Submitted')
    }
    
</script>

<template>
    <div class="container">
      <h1>Gi oss tilbakemelding</h1>
      <form @submit.prevent="onSubmit">
        <FeedBackInput
          v-model="feedback.name"
          label="Navn"
          type="text"
        ></FeedBackInput>

        <FeedBackInput
          label="Epost"
          type="email"
          v-model="feedback.email"
          error="Her er det eil"

        ></FeedBackInput>

        <FeedBackInput
          label="Melding"
          v-model="feedback.message"
          class="message"
          type="text"
          error="Her er det eil"
        ></FeedBackInput>
        <button type="submit">Send inn</button>
      </form>

      <pre>{{ feedback }}</pre>
    </div>
</template>

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