export class RegistarPage {

    constructor(page) {
        this.page = page

        this.emailInput = page.getByPlaceholder('E-mail')
        this.passlInput = page.getByPlaceholder('password')
        this.registerButton = page.getByRole('button',{name: 'Register'})

    }

    signupAsNewUser = async (email, password) => {

        await this.emailInput.waitFor()

        await this.emailInput.fill(email)

        await this.passlInput.waitFor()
        await this.passlInput.fill(password)
        
        await this.registerButton.waitFor()
        await this.registerButton.click()

    }


}