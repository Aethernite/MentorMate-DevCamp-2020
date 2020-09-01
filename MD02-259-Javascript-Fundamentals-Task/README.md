# 1. EcmaScript 2020 specification introduces some super cool new features. List any 3 new features (that you understand) and research which JavaScript engines, browsers (and browser versions) already support them and which - not yet.


## a) Dynamic Import
```js
import { max } from '../math.js';
const nums = [1, 2, 3];
max(...nums); // 3
```
- This has been the way we could import a file. And the JavaScript engine reads the modules in the file and bring them into the file where those modules are called. But now, you can do this as follows.
```js
const numbs = [1, 2, 3];
if (numbs.length) {
  const math = '../math';
  import(math)
    .then(module => {
      module.max(...numbs);
    })
}
```
- #### Browsers that support BigInt:
    - :white_check_mark: Google Chrome 63+
    - :white_check_mark: Mozilla Firefox 67+
    - :white_check_mark: Safari 11.1


## b) BigInt
 - When you had to add two numbers that are too big enough to cause an overflow, weren’t you suffered? BigInts are a new numeric primitive in JavaScript that can represent integers with arbitrary precision. With BigInts, you can safely store and operate on large integers even beyond the safe integer limit for Numbers. To create a BigInt, add the n suffix to any integer literal. For example, 123 becomes 123n. The global BigInt(number) function can be used to convert a Number into a BigInt. In other words, BigInt(123) === 123n
 However, unfortunately, you can’t make a BigInt with a float number. And also, you can’t use a BigInt and a Number together, either. BigInts support the most common operators. Binary +, -, *, and ** all work as expected. / and % work, and round towards zero as needed. Bitwise operations |, &, <<, >>, and ^ perform bitwise arithmetic assuming a two’s complement representation for negative values, just like they do for Numbers.
- #### Browsers that support BigInt:
    - :white_check_mark: Google Chrome 67+
    - :white_check_mark: Mozilla Firefox 68+
    - :x: Safari

## c) Optional Chaining
 - Long chains of property accesses in JavaScript can be error-prone, as any of them might evaluate to null or undefined (also known as “nullish” values). Checking for property existence on each step easily turns into a deeply-nested structure of if-statements or a long if-condition replicating the property access chain:
 ```javascript
 const nameLength =
  (db
    ? (db.user
      ? (db.user.name
        ? db.user.name.length
        : undefined)
      : undefined)
    : undefined);
 ```
- Using the new optional chaining operator, we can rewrite the above example as follows:
 ```javascript
 // Still checks for errors and is much more readable.
const nameLength = db?.user?.name?.length;
 ```
 - #### Browsers that support Optional Chaining:
   - :white_check_mark: Google Chrome 80+
    - :white_check_mark: Mozilla Firefox 74+
    - :white_check_mark: Safari 13.1+

# 2. Explain in your words why null is an object in JavaScript, but null instanceof Object returns false.
- **null** is actually a primitive value but typeof null returns "object" because of a bug since the creation of JS. **null** is often used to signify an empty reference to an object.
> https://stackoverflow.com/questions/20480729/why-does-typeofnull-return-object-but-you-cant-assign-properties-to-it
- The instanceof operator tests whether the prototype property of a constructor appears anywhere in the prototype chain of an object.
> https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/instanceof

- So my guess is that null's prototype(if it exists) don't have Object constructor in its prototype chain & thus it returns false.