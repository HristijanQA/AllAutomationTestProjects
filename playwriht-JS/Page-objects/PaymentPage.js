import { expect } from "@playwright/test"

export class PaymentPage {

    constructor(page) {
        this.page = page

        this.discountCode = page.frameLocator('iframe').locator('[data-qa="discount-code"]')
        this.dicsountInput = page.getByPlaceholder('Discount code')
        this.dicsountInputButton = page.getByRole('button', { name: 'Submit discount' })
        this.discoutMessage = page.locator('[data-qa="discount-active-message"]')
        this.regularPrice = page.locator('[data-qa="total-value"]')
        this.discoutedPrice = page.locator('[data-qa="total-with-discount-value"]')
        this.cardNameInput = page.locator('[data-qa="credit-card-owner"]')
        this.carNumberInput = page.locator('[data-qa="credit-card-number"]')
        this.carDateInput = page.locator('[data-qa="valid-until"]')
        this.carCVCInput = page.locator('[data-qa="credit-card-cvc"]')
        this.payButton = page.getByRole('button', { name: 'Pay' })

    }

    activateDiscout = async () => {
 
        const discoutCodeText =   await this.discountCode.innerText()
        console.log(discoutCodeText)
         await this.dicsountInput.waitFor()
// option 1
        await this.dicsountInput.fill(discoutCodeText)
        await expect(this.dicsountInput).toHaveValue(discoutCodeText)
// option 2
        // await this.dicsountInput.focus()
        // await this.page.keyboard.type(discoutCodeText, {delay: 1000})
        // expect(await this.dicsountInput.inputValue()).toBe(discoutCodeText)

        expect (await this.discoutMessage.isVisible()).toBe(false)
        await this.dicsountInputButton.waitFor()
        await this.dicsountInputButton.click()

        await this.discoutMessage.waitFor()
        expect(await this.discoutMessage.innerText()).toBe("Discount activated!")

        const discountValueText = await this.discoutedPrice.innerText()
        const discountValueOnlyNumber = discountValueText.replace("$","")
        const discountValueOnlyNumber2 = parseInt(discountValueOnlyNumber, 10)
        
        const regularValueText = await this.regularPrice.innerText()
        const regularValueOnlyNumber = regularValueText.replace("$","")
        const regularValueOnlyNumber2 = parseInt(regularValueOnlyNumber, 10)

        expect(regularValueOnlyNumber2).toBeGreaterThan(discountValueOnlyNumber2)

    }

    populatedCC = async (paymentDetails) =>{

        await this.cardNameInput.waitFor()
        await this.cardNameInput.fill(paymentDetails.cardName)

        await this.carNumberInput.waitFor()
        await this.carNumberInput.fill(paymentDetails.cardNumber)

        await this.carDateInput.waitFor()
        await this.carDateInput.fill(paymentDetails.cardDate)

        await this.carCVCInput.waitFor()
        await this.carCVCInput.fill(paymentDetails.cardCVC)

    }

    completePayment = async () => {

        await this.payButton.waitFor()
        await this.payButton.click()

        await this.page.waitForURL(/\/thank-you/, {timeout: 3000})

    }
}