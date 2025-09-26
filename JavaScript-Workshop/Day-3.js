
async function bus() {
    let response = await fetch("http://localhost:8080/api/bus/user/findAllBuses")
    let data = await response.json()
    console.log(data)
}

let count = 0;
for(let i=0;i<100;i++) {
    if(i%2 == 0) {
        count += 2;
        console.log(count);
    }
}


let str = "Hello";
str = str.split("").reverse().join("")


console.log(str)
console.log()


let arr = [10,20,40,50,60]
arr.push(34);
arr.pop()
arr.unshift(1,2)
arr.shift()
let sliceArray = arr.slice(2,arr.length-1);
arr.splice(2, 2, 89)
console.log(arr)
console.log(sliceArray)