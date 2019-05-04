

Some techniques for getting around jackson mapping issues.

Jackson needs two things to work
- A Default constructor
- Properly named fields and getters (POJO spec)

But what if a domain class doesnt have these traits and you cant change them! 
(A class in a third party jar for example)

The use of Mixin's solves these problems

### 1. no default constructor

Website Domain Object

### 2. non matching getters names

Account Domain Object
