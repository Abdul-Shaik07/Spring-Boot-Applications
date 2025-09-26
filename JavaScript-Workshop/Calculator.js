// let calculator = (firstNumber, secondNumber) => {
//     return firstNumber + secondNumber;
// }
// calculator(firstNumber, secondNumber);

let calculator = () => {
let firstNumber = parseFloat(document.querySelector(".firstNumber").value)
let secondNumber = parseFloat(document.querySelector(".secondNumber").value)
let total = firstNumber + secondNumber
document.querySelector(".result").innerText = "Result: " + total 
}