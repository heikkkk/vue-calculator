<template>
    <div>
        <input
            type="text"
            :value="expression"
            @input="handleInputUpdate"
            readonly
            @keydown.prevent
            class="disable-cursor"
        />
    </div>

</template>

<script lang="ts">
export default {
    props: {
        expression: {
            type: String,
            required: true
        }
    },
    methods: {
        handleInputUpdate(event: Event) {
            this.$emit('input-update', event)
        }
    }

}
</script>

<style scoped>
.disable-cursor {
   /* Example cursor style for read-only input */
  cursor: default;
}
input {
    width: 100%;
    height: 50px;
    box-shadow: 4px 8px 0 #000;
    border: 1px solid #000;
    border-radius: 4px;
}
</style>
