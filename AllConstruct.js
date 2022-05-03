const allConstruct = (target, wordBank) => {
    if (target === '') {
        return [[]];
    }

    const result = [];

    for (let word of wordBank) {
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            // assume correct behavior while writing recursive algorithms
            const suffixWays = allConstruct(suffix, wordBank);
            const targetWays = suffixWays.map(way => [ word, ...way ]);
            result.push(...targetWays);
        }
    }
    return result;
};

const memAllConstruct = (target, wordBank, memo={}) => {
    if (target in memo) {
        return memo[target];
    }
    if (target === '') {
        return [[]];
    }

    const result = [];

    for (let word of wordBank) {
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            // assume correct behavior while writing recursive algorithms
            const suffixWays = allConstruct(suffix, wordBank);
            const targetWays = suffixWays.map(way => [ word, ...way ]);
            result.push(...targetWays);
        }
    }
    memo[target] = result;
    return result;
};

console.log(allConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']));
console.log(allConstruct('aaaaaaaaaaaaaaaaaz', ['a', 'aa', 'aaa', 'aaaa']));