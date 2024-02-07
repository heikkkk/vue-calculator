describe('feedback page', () => {
  beforeEach(() => {
    cy.visit('/feedback')
  })

  it('the h1 contains the correct text', () => {
    cy.get('[data-cy="page-title"]').contains("Gi oss tilbakemelding")
  })

  it('success message is displayed when successfully posting to backend', () => {
    cy.get("[data-cy='name-input']").type("user-test")
    cy.get("[data-cy='email-input']").type("email@test.no")
    cy.get("[data-cy='message-input']").type("message-test")
    cy.get("[data-cy='name-input']").type("user-test")
    cy.get("[data-cy='form-button']").click()
    cy.get("[data-cy='success-message']").should("exist").contains('Success')
  })

  it('submit button is disabled when input fields are invalid', () => {
    cy.get("[data-cy='name-input']").should("be.empty")
    cy.get("[data-cy='email-input']").should("be.empty")
    cy.get("[data-cy='message-input']").should("be.empty")
    cy.get("[data-cy='form-button']").should("be.disabled")
  })
})