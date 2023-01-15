# good_NEWS
 **The good_NEWS** project is about the cryptographic diffusion as identified by Claude Shannon. Four basic algorithms is developed and
 six implementations of the algorithm is presented. These algorithms are based on some specific solutions of homogenous
 linear Diophantine equation in n unknowns, where n>=2. The algorithms can be iterated yielding distinct orbits until convergence.
 Note that even(character string) converges back to the original input(bijective) while odd(character string) may converge to the
 original input or may converge to a string that shares similar characteristics with the original input. 
 
 **Homogenous linear Diophantine equation**:
 
 It is an equation of the form 
 
 **a1x1 + a2x2 + a3x3 + ... + an-1 + an = 0**
 
 where all ai are integer coefficients and all xi are solutions in integers
 
 The above linear Diophantine equation has solution in integers because of the following
 
 (1) The gcd of a set of integers is positive or a natural number
 
 (2) All natural numbers divides zero (satisfying the Bezout identity)
 
 
 **The four algorithms or functions**
 
 The term **a0x0** will be referred to as '**Adadu** term'
 
 The **North** function
 
 There exist the **Adadu** term **a0x0** for which
 
x0 = (a1+a2+a3+...+an-1+an)

a0 = 0

**Function** 

xk+1 = xk - ak - ak+1

**Inverse Function**(same as **South** function) 

x0 = x1 - x2 + x3 - ... +xn-1 - xn

a0 = 0

ak+1 = -xk+1 + xk - ak

 The **East** function
 
 There exist the **Adadu** term **a0x0** for which
 
x0 = -(a1+a2+a3+...+an-1+an)

a0 = 0

**Function** 

xk+1 = xk + ak + ak+1

**Inverse Function**(same as **West** function) 

ak+1 = xk+1 -xk -ak

x0 = -x1 + x2 - x3 + ... -xn-1 + xn

a0 = 0

 The **West** function
 
 There exist the **Adadu** term **a0x0** for which
 
x0 = a1-a2+a3-...+an-1-an

a0 = 0

**Function**

xk+1 = -xk - ak + ak+1

**Inverse Function**(same as **East** function) 

x0 = x1 + x2 + x3 + ... +xn-1 + xn

a0 = 0

 ak+1 = xk+1 + xk + ak
 
 The **South** function
 
 There exist the **Adadu** term **a0x0** for which
 
x0 = (-a1+a2-a3+...-an-1+an)

a0 = 0

**Function** 

xk+1 = -xk + ak - ak+1

**Inverse Function**(same as **North** function) 

x0 = -(x1 + x2 + x3 + ... + xn-1 + xn)

a0 = 0

ak+1 = -xk+1 -xk + ak

where

ak is integer coefficient

xk is integer variable

 k = 0,1,2,...,n-1,n
 
 **Modulo** if byte ...memory, matrix
 
 **Diffusion**:
 
Diffusion is achieved whenever each of the ciphertext characters(or blocks) is affected by more than one plaintext characters(blocks).
meaning if a single plaintext character is changed it will cause more than half of the ciphertext characters to change and similarly
if a single ciphertext character is changed, it will cause more than half of plaintext character to change. A diffusion method should
exhibit the avalanche effect i.e a slight change in the input should cause drastic change in the output and vice versa.
The four algorithms(functions) so presented and its six implementations satisfies the avalanche effect thereby frustrating statistical
analysis on plaintext.

**Iterated function**:

The four algorithms or functions can be iterated generating sequence of distinct orbits until the convergence criteria is met
