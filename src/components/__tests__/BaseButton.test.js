import { mount } from "@vue/test-utils";
import BaseButton from "@/components/BaseButton.vue";
import { describe, expect, test } from "vitest";

describe('BaseButton', () => {
    test('receives prop value as "+"', () => {
        const wrapper = mount(BaseButton, {
            props: {
                value: '+'
            },
        })
        expect(wrapper.props('value')).toBe('+')
    })

    test('receives prop "-", but expects "+", is wrong', () => {
        const wrapper = mount(BaseButton, {
            props: {
                value: '-'
            },
        })
        expect(wrapper.props('value')).not.toBe('+')
    })

    test('clicking input emits an event', async() => {
        const wrapper = mount(BaseButton, {
            data() {
                return {
                    clicked: false,
                }
            }
        })
        const inputButton = wrapper.find('input')
        await inputButton.trigger('click')
        expect(wrapper.emitted()).toHaveProperty('updateExpression')
    })
})