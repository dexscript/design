let fetchSingleElement = function (arg) {
    console.log('fetch single element', arg);
    return arg;
};

let fetchBatchElements = function (args) {
    console.log('fetch batch elements', args);
    return args;
};

let fakeResult = {};

function speculativeExecute(f) {
    let cache = {};
    let collectedArgs = [];
    fetchSingleElement = function (arg) {
        if (cache[arg] !== undefined) {
            return cache[arg];
        }
        collectedArgs.push(arg);
        return fakeResult
    };
    while(true) {
        let result = f();
        if (collectedArgs.length === 0) {
            return result;
        }
        for (const [arg, fetched] of fetchBatchElements(collectedArgs).entries()) {
            cache[arg] = fetched;
        }
        collectedArgs = [];
    }
}

function businessLogic() {
    let result = 0;
    for (let i = 0; i < 10; i++) {
        result += fetchSingleElement(i);
    }
    return result;
}

// console.log('result', businessLogic());
console.log('result', speculativeExecute(businessLogic));