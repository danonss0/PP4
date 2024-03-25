const hello = () => alert("It works!");
hello();
async function logProduct() {
  const response = await fetch("/api/products");
  const products = await response.json();
  console.log(products);
}