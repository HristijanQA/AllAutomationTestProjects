import { test, expect } from "@playwright/test";

test("Product page", async ({ page }) => {

await page.goto("/");

const addToBasketButton = page.locator('//button[@data-qa="product-button"]').first();
const busketCounter = page.locator('//div[@data-qa="header-basket-count"]');

await addToBasketButton.waitFor();
await expect(addToBasketButton).toHaveText("Add to Basket")
await expect(busketCounter).toHaveText("0")

await addToBasketButton.click();

await expect(addToBasketButton).toHaveText("Remove from Basket")
await expect(busketCounter).toHaveText("1")

//await page.pause();

const checkOutLink = page.getByRole('link', { name: 'Checkout' })
await checkOutLink.waitFor();
await checkOutLink.click();

await page.waitForURL("/basket");



//console.log(await page.getByRole('button', { name: 'Add to Basket' }).count())
})

// const addTwoNumbers = (a, b) => {
// console.log("Adding up two numbers")
// return a + b
// }