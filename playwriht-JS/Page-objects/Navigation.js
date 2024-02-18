
export class Navigation {

    constructor(page) {
        this.page = page

        this.busketCouner = page.locator('[data-qa="header-basket-count"]')
        this.checkOutLink = page.getByRole('link', { name: 'Checkout' })
    }


    getBasketCount = async () => {
        await this.busketCouner.waitFor()
        const text = await this.busketCouner.innerText()
        return parseInt(text, 10)  
    }

    goToCheckOut = async () =>{
        await this.checkOutLink.waitFor();
        await this.checkOutLink.click();
        await this.page.waitForURL("/basket");
    }

    
}