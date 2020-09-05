/*
Sort Array. Sorting an array means to arrange its elements in increasing order. 
Write a JavaScript function sortArray(value) to sort an array. 
Use the "selection sort" algorithm: find the smallest element, move it at the first position, find the smallest from the rest, move it at the second position, etc. 
Write JS program arraySorter.js that invokes your function with the sample input data below and prints the output at the console.
*/
function selectionSort(arr,index){
  if(arr.length-1 == index){
    return arr;
  }
  let min = Math.min(...arr.slice(index));
  let min_index = arr.lastIndexOf(min);
  let temp = arr[index];
  arr[index] = min;
  arr[min_index] = temp;
  return selectionSort(arr,++index);
}
arr = [12, 12, 50, 2, 6, 22, 51, 712, 6, 3, 3];
console.log(selectionSort(arr,0));
arr = [5, 4, 3, 2, 1];
console.log(selectionSort(arr,0));
arr = [3, 74, -1, -22, 1, 0, 17];
console.log(selectionSort(arr,0));
