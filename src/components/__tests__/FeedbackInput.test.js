import { mount } from "@vue/test-utils";
import FeedbackInput from "@/components/FeedbackInput.vue";
import { describe, expect, test } from "vitest";

describe('FeedbackInput', () => {
    test('error message is displayed', () => {
        const wrapper = mount(FeedbackInput, {
            props: {
                error: 'testError'
            }
        })

        expect(wrapper.find("p").text()).toEqual('testError')
    })

   
})