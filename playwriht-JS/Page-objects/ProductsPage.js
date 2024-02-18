import { expect } from "@playwright/test"
import { Navigation } from "./Navigation"

export class ProductPage {

    constructor(page) {
        this.page = page

        this.addButtons = page.locator('[data-qa="product-button"]')
        this.sortDropDown = page.locator('[data-qa="sort-dropdown"]')
        this.productTitle = page.locator('[data-qa="product-title"]')
     
    }

    visit = async ()=>{
        await this.page.goto("/")
    }


    addProductToCart = async (index) => {
    const specificAddbutton = this.addButtons.nth(index)

       await specificAddbutton.waitFor()
       await expect(specificAddbutton).toHaveText("Add to Basket")
       const navigation = new Navigation(this.page)
       const getBasketCountBeforeAdding = await navigation.getBasketCount()
       await specificAddbutton.click()
       await expect(specificAddbutton).toHaveText("Remove from Basket") 
       const getBasketCountAfterAdding = await navigation.getBasketCount()
       expect(getBasketCountAfterAdding).toBeGreaterThan(getBasketCountBeforeAdding)

    }

    sortByChepest = async () => {
        await this.sortDropDown.waitFor()
        await this.productTitle.first().waitFor()
        const productTitlesBefore = await this.productTitle.allInnerTexts()
        await this.sortDropDown.selectOption("price-asc")
        const productTitlesafter = await this.productTitle.allInnerTexts()  
        expect(productTitlesafter).not.toEqual(productTitlesBefore)

 
    }



}