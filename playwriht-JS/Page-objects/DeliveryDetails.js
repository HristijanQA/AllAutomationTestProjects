import { expect } from "@playwright/test"

export class DeliveryDetails {

    constructor(page) {
        this.page = page

        this.nameInput = page.getByPlaceholder('First name')
        this.lastNameInput = page.getByPlaceholder('Last name')
        this.streetInput = page.getByPlaceholder('Street')
        this.postCodetInput = page.getByPlaceholder('Post code')
        this.cityInput = page.getByPlaceholder('City')
        this.selectContry = page.locator('[data-qa="country-dropdown"]')
        this.saveAddress = page.getByRole('button', { name: 'Save address for next time' })
        this.continueToPay = page.getByRole('button', { name: 'Continue to payment' })
        this.savedAddressContainder = page.locator('[data-qa="saved-address-container"]')

        this.savedAddressFirstName = page.locator('[data-qa="saved-address-firstName"]')
        this.savedAddresslastName = page.locator('[data-qa="saved-address-lastName"]')
        this.savedAddressStreet = page.locator('[data-qa="saved-address-street"]')
        this.savedAddressPostcode = page.locator('[data-qa="saved-address-postcode"]')
        this.savedAddressCity = page.locator('[data-qa="saved-address-city"]')
        this.savedAddressCountry = page.locator('[data-qa="saved-address-country"]')

    
    }

    fillDetails = async (userAddress) => {
        await this.nameInput.waitFor()
        await this.nameInput.fill(userAddress.firstName)

        await this.lastNameInput.waitFor()
        await this.lastNameInput.fill(userAddress.lastName)

        await this.streetInput.waitFor()
        await this.streetInput.fill(userAddress.street)

        await this.postCodetInput.waitFor()
        await this.postCodetInput.fill(userAddress.postCode)

        await this.cityInput.waitFor()
        await this.cityInput.fill(userAddress.city)

        await this.selectContry.waitFor()
        await this.selectContry.selectOption(userAddress.state)

    }

    saveDetails = async () => {

        const addressCountBeforeSaving = await this.savedAddressContainder.count()

        await this.saveAddress.waitFor()
        await this.saveAddress.click()

        expect(this.savedAddressContainder).toHaveCount(addressCountBeforeSaving + 1)

        await this.savedAddressFirstName.first().waitFor()
        expect(await this.savedAddressFirstName.first().innerText()).toBe(await this.nameInput.inputValue())
        expect(await this.savedAddresslastName.first().innerText()).toBe(await this.lastNameInput.inputValue())
        expect(await this.savedAddressStreet.first().innerText()).toBe(await this.streetInput.inputValue())
        expect(await this.savedAddressPostcode.first().innerText()).toBe(await this.postCodetInput.inputValue())
        expect(await this.savedAddressCity.first().innerText()).toBe(await this.cityInput.inputValue())
        expect(await this.savedAddressCountry.first().innerText()).toBe(await this.selectContry.inputValue())


    }

    continueToPayment = async () =>{

        await this.continueToPay.waitFor()
        await this.continueToPay.click()
        await this.page.waitForURL(/\/\payment/, {timeout: 3000})

    }

}