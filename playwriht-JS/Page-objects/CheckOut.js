import { expect } from "@playwright/test"

export class Checkout {

    constructor(page) {
        this.page = page

        this.basketCards = page.locator('[data-qa="basket-card"]')
        this.basketItemPrice = page.locator('[data-qa="basket-item-price"]')
        this.removeItemFromBusket = page.locator('[data-qa="basket-card-remove-item"]')
        this.checkOutButton = page.locator('[data-qa="continue-to-checkout"]')

    }

    removeChepestProduct = async () =>{

        await this.basketCards.first().waitFor()
        const itemsBeforeRemovel = await this.basketCards.count()

        await this.basketItemPrice.first().waitFor()
        const allPricesText = await this.basketItemPrice.allInnerTexts()
        // [ '499$', '599$', '320$' ]
        const justNumbers = allPricesText.map((element) => {
            console.warn({element})
            const withOutDollarSing = element.replace("$","")
            return parseInt(withOutDollarSing, 10)
        })

        console.warn({allPricesText})
        console.warn({justNumbers})

        const smallestPrice = Math.min(...justNumbers)
        const smallsestPriceIdx = justNumbers.indexOf(smallestPrice)
        const specificRemoveBitton = this.removeItemFromBusket.nth(smallsestPriceIdx)
        await specificRemoveBitton.waitFor()
        await specificRemoveBitton.click()

        await expect(this.basketCards).toHaveCount(itemsBeforeRemovel - 1) 
        
    }

    continueToCheckOut = async () => {

        await this.checkOutButton.waitFor()
        await this.checkOutButton.click()
        await this.page.waitForURL(/\/login/, {timeout: 3000})

    }

}