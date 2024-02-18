export class LogInPage {

    constructor(page) {
        this.page = page

        this.registerButton = page.locator('[data-qa="go-to-signup-button"]')
    }

    moveToSingup = async () => {
        await this.registerButton.waitFor()
        await this.registerButton.click()
        await this.page.waitForURL(/\/signup/, {timeout: 3000})
        
    }
}