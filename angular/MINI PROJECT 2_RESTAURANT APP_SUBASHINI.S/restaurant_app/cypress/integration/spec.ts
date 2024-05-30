describe('My First Test', () => {
  it('Visits the initial project page', () => {
    cy.visit('/')
    cy.contains('LOGIN')
    cy.contains('SIGNUP')
    cy.contains('LOG OUT')

  })

  })

  describe('Login Test', () => {
    it('Visits login page', () => {
      cy.visit('/login)')
     })
  
    
    it('Have a text box', () => {
      cy.get('.name').type("Subashini");
      cy.get('.password').type("suba@123!");
      cy.get('button').click();
  
    })
  })

  describe('Menu card Test', () => {
    it('Visits Menu card page', () => {
      cy.visit('/viewMenuCardpage')
      cy.contains('WELCOME CUSTOMER!')
      
    })
  
    })

    describe('Admin Page Test', () => {
      it('Visits Admin page', () => {
        cy.visit('/RestaurantDashBoard')
        cy.contains('WELCOME ADMIN')
        
      })
    
      })
      describe('Admin CRUD operation Page', () => {
        it('Visits Admin page', () => {
          cy.visit('/MenuCardpage')
          cy.contains('Menu Items')
          
        })
      
        })
  