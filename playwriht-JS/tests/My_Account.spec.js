import {test} from "@playwright/test"
import { MyAccountPage } from "../Page-objects/MyAccountPage"
import { getLogInToken } from "../api-calls/getLogInTocken"
import {adminDetails} from "../data/userDetails"

test.only("My account using cookies", async ({page}) => {

const myAccount = new MyAccountPage(page)


const loginToken = await getLogInToken(adminDetails.username,adminDetails.password)
console.warn({loginToken})

await myAccount.visit()
await page.evaluate(([loginTokenInBrowser])=>{

    document.cookie = "token=" + loginTokenInBrowser  
},[loginToken])

await myAccount.visit()
await page.pause()
})