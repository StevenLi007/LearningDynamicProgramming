const numBaseCases = 2;

const fib = (n) => {
    const table = Array(n + 1).fill(0);
    table[1] = 1;
    for (let i = 0; i <= n - numBaseCases; i++) {
        table[i + 1] += table[i];
        table[i + 2] += table[i];
    }
    table[n] += table[n - 1];
    return table[n];
}

console.log(fib(6));
console.log(fib(50));