<script setup>
import UniqueID from '@/features/UniqueID.ts'

const uuid = UniqueID().getID()

const props = defineProps({
    label: [String, Number],
    error: String
})

const model = defineModel()
</script>

<template>
    <div id="container" >
        <label 
            v-if="label"
            :for="uuid"
        >
            {{ label }}
        </label>
        <input
            v-bind="$attrs"
            v-model="model"
            :placeholder="label"
            :id="uuid"
            :aria-describedby="error ? `${uuid}-error` : null"
            :aria-invalid="error ? true : null"
        >
    </div>
    <p
        v-if="error"
        class="errorMessage"
        :id="`${uuid}-error`"
        aria-live="assertive"   
    >
        {{ error }}    
    </p>
</template>

<style scoped>
label {
    color: aliceblue;
    
}

#container {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
    }

#field {
    width: 100%;
    box-sizing: border-box;
    margin-bottom: 10px;
    height: 100%;
}

.errorMessage {
  color: red;
}

</style>
