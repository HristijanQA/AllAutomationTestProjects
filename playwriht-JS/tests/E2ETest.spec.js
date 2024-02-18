import { v4 as uuidv4 } from "uuid"
import {test} from "@playwright/test"
import { ProductPage } from "../Page-objects/ProductsPage"
import { Navigation } from "../Page-objects/Navigation"
import { Checkout } from "../Page-objects/CheckOut"
import {LogInPage} from "../Page-objects/LogInPage"
import {RegistarPage} from "../Page-objects/RegistarPage"
import {DeliveryDetails} from "../Page-objects/DeliveryDetails"
import { deliveryDetails as userAddress } from "../data/deliveryDetails"
import { PaymentPage } from "../Page-objects/PaymentPage"
import { paymentDetails } from "../data/paymentDetails"

test("New user end to end test", async ({page}) =>{

const productPage = new ProductPage(page)
const navigation = new Navigation(page)
const checkout = new Checkout(page)
const logInPage = new LogInPage(page)
const registarPage = new RegistarPage(page)
const deliveryDetails = new DeliveryDetails(page)
const paymentPage = new PaymentPage(page)

const email = uuidv4() + "gmail.com"
const password = uuidv4()

await productPage.visit()

await productPage.sortByChepest()

await productPage.addProductToCart(0)
await productPage.addProductToCart(1)
await productPage.addProductToCart(2)

await navigation.goToCheckOut()

await checkout.removeChepestProduct()
await checkout.continueToCheckOut()

await logInPage.moveToSingup()

await registarPage.signupAsNewUser(email,password)

await deliveryDetails.fillDetails(userAddress)
await deliveryDetails.saveDetails()
await deliveryDetails.continueToPayment()

await paymentPage.activateDiscout()
await paymentPage.populatedCC(paymentDetails)
await paymentPage.completePayment()
})