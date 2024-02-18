import * as nodeFetch from "node-fetch"

export const getLogInToken = async (username, password) => {

const responcse = await nodeFetch("http://localhost:2221/api/login",{
    method: "POST",
    body: JSON.stringify({"username": username,"password": password}),
})
if (responcse.status !== 200){
    throw new Error("something went wrong")
}
const body = await responcse.json()
return body.token

}