<template>
    <input  
        type="button"
        :value="value"
        @click="$emit('updateExpression', value)"
        :v-bind="value"
    />
</template>

<script lang="ts">
export default {
    props: {
        value: {
            type: String,
            default: ''
        }
    },
    emits: [ 'updateExpression' ]
}
</script>

<style scoped>
input {
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

:hover {
    box-shadow: 4px 4px 0 #000;
    transform: translate(-4px,-4px);
}
:focus-visible{
    outline-offset: 1px;
}
</style>
