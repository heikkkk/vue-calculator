import { createRouter, createWebHistory } from 'vue-router'
import CalculatorView from '@/views/CalculatorView.vue'
import FeedbackForm from '@/views/FeedbackForm.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'calculator',
      component: CalculatorView
    },
    {
      path: '/feedback',
      name: 'feedback',
      component: FeedbackForm
    }
  ]
})

export default router
