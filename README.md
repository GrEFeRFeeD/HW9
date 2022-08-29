# Console output

Testing MyArrayList...<br>
Testing constructor (1/2) | Initializing list with given collection of {1, 3, 5, 7}<br> 
MyArrayList: [1, 3, 5, 7, null, null, null, null, null], size=4<br>
Clearing the list...<br>
MyArrayList: [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=0<br>
Testing constructor (2/2) | Initializing list without arguments<br>
MyArrayList: [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=0<br>
Filling list with numbers 0 ... 9:<br>
MyArrayList: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, null, null, null, null, null, null, null, null, null, null, null, null], size=10<br>
Getting and removing certain elements:<br>
Removing 9th element (9)<br>
MyArrayList: [0, 1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null], size=9<br>
Removing 0th element (0)<br>
MyArrayList: [1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null, null], size=8<br>
Removing 6th element (7)<br>
MyArrayList: [1, 2, 3, 4, 5, 6, 8, null, null, null, null, null, null, null, null], size=7<br>
Removing 2th element (3)<br>
MyArrayList: [1, 2, 4, 5, 6, 8, null, null, null, null, null, null, null, null, null], size=6<br>
Getting 1000th element:<br>
Catched IndexOutOfBoundsException at index 1000<br>
Removing -1000th element:<br>
Catched IndexOutOfBoundsException at index -1000<br>
Getting size of list: 6<br>
MyArrayList testing complete.<br>
<br>
Testing MyLinkedList...<br>
Testing constructor (1/2) | Initializing list with given collection of {1, 3, 5, 7}<br>
MyLinkedList: { 1, 3, 5, 7 }, size=4<br>
Clearing the list...<br>
MyLinkedList: {  }, size=0<br>
Testing constructor (2/2) | Initializing list without arguments<br>
MyLinkedList: {  }, size=0<br>
Filling list with numbers 0 ... 9:<br>
MyLinkedList: { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, size=10<br>
Getting and removing certain elements:<br>
Removing 9th element (9)<br>
MyLinkedList: { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, size=9<br>
Removing 0th element (0)<br>
MyLinkedList: { 1, 2, 3, 4, 5, 6, 7, 8 }, size=8<br>
Removing 6th element (7)<br>
MyLinkedList: { 1, 2, 3, 4, 5, 6, 8 }, size=7<br>
Removing 2th element (3)<br>
MyLinkedList: { 1, 2, 4, 5, 6, 8 }, size=6<br>
Getting 1000th element:<br>
Catched IndexOutOfBoundsException at index 1000<br>
Removing -1000th element:<br>
Catched IndexOutOfBoundsException at index -1000<br>
Getting size of list: 6<br>
MyLinkedList testing complete.<br>
<br>
Testing MyQueue...<br>
Testing constructor (1/2) | Initializing queue with given collection of {1, 3, 5, 7}<br>
MyQueue: { 1, 3, 5, 7 }, size=4<br>
Clearing the queue...<br>
MyQueue: {  }, size=0<br>
Testing constructor (2/2) | Initializing queue without arguments<br>
MyQueue: {  }, size=0<br>
Filling queue with numbers 0 ... 9:<br>
MyQueue: { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, size=10<br>
Peeking queue: 0<br>
Polling queue: 0<br>
MyQueue: { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, size=9<br>
Removing value 5 from queue: true<br>
MyQueue: { 1, 2, 3, 4, 6, 7, 8, 9 }, size=9<br>
Removing unrepresented value 50 from queue: false<br>
MyQueue: { 1, 2, 3, 4, 6, 7, 8, 9 }, size=9<br>
Getting size of queue: 9<br>
MyQueue testing complete.<br>
<br>
Testing MyStack...<br>
Testing constructor (1/2) | Initializing stack with given collection of {1, 3, 5, 7}<br>
MyStack: { 7, 5, 3, 1 }, size=4<br>
Clearing the stack...<br>
MyStack: {  }, size=0<br>
Testing constructor (2/2) | Initializing stack without arguments<br>
MyStack: {  }, size=0<br>
Filling stack with numbers 0 ... 9:<br>
MyStack: { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, size=10<br>
Peeking stack: 9<br>
Popping stack: 9<br>
MyStack: { 8, 7, 6, 5, 4, 3, 2, 1, 0 }, size=9<br>
Removing value 5 from stack: true<br>
MyStack: { 8, 7, 6, 4, 3, 2, 1, 0 }, size=9<br>
Removing unrepresented value 50 from stack: false<br>
MyStack: { 8, 7, 6, 4, 3, 2, 1, 0 }, size=9<br>
Getting size of stack: 9<br>
MyStack testing complete.<br>
<br>
Testing MyHashMap...<br>
Testing constructor (1/2) | Initializing map with {1=One, 100=One hundred, 10=Ten}<br>
Getting keySet: [1, 100, 10]<br>
Getting valueSet: [One, One hundred, Ten]<br>
Getting nodeSet: [EntryNode{key=10, hash=10, value=Ten}, EntryNode{key=100, hash=100, value=One hundred}, EntryNode{key=1, hash=1, value=One}]<br>
Getting size: 3<br>
Clearing map:[]<br>
Testing constructor (2/2) | Initializing map without arguments<br>
Putting new pair [0, Zero]<br>
MyHashMap: {<br>
    0 : { [0 = Zero] },<br>
    1 : { },<br>
    2 : { },<br>
    3 : { },<br>
    4 : { },<br>
    5 : { },<br>
    6 : { },<br>
    7 : { },<br>
    8 : { },<br>
    9 : { },<br>
    10 : { },<br>
    11 : { },<br>
    12 : { },<br>
    13 : { },<br>
    14 : { },<br>
    15 : { }<br>
}<br>
Collision test: putting new pair [16, Sixteen]<br>
MyHashMap: {<br>
    0 : { [0 = Zero],  [16 = Sixteen] },<br>
    1 : { },<br>
    2 : { },<br>
    3 : { },<br>
    4 : { },<br>
    5 : { },<br>
    6 : { },<br>
    7 : { },<br>
    8 : { },<br>
    9 : { },<br>
    10 : { },<br>
    11 : { },<br>
    12 : { },<br>
    13 : { },<br>
    14 : { },<br>
    15 : { }<br>
}<br>
Getting value by key 16: Sixteen<br>
Getting value by unrepresented key 32: null<br>
[EntryNode{key=0, hash=0, value=Zero}, EntryNode{key=16, hash=16, value=Sixteen}]<br>
Removing pair by key 0:<br>
[EntryNode{key=16, hash=16, value=Sixteen}]<br>
Removing pair by unrepresented key 32:<br>
[EntryNode{key=16, hash=16, value=Sixteen}]<br>
MyHashMap testing complete.<br>
<br>
<br>
Process finished with exit code 0<br>
