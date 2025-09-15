<h1 style="font-weight:bold;">ATM Dispensing System using Chain of Responsibility</h1>
<h2 style="font-weight:bold;"> Problem Statement</h2>
<span style="font-weight:bold;">The Problem: </span>
Imagine you're building an ATM Dispensing System where different bill denominations need to be handled in a specific order to efficiently dispense cash:

$50 bills: Highest denomination

$20 bills: Second highest denomination

$10 bills: Medium denomination

$5 bills: Lower denomination

$1 bills: Smallest denomination

Traditional Approach (Bad Code):

```
    public class ATMDispenser {
        public void dispenseCash(int amount) {
            int remaining = amount;

        if (remaining >= 50) {
            int num50 = remaining / 50;
            System.out.println("Dispensing " + num50 + " $50 bill(s)");
            remaining %= 50;
        }
        
        if (remaining >= 20) {
            int num20 = remaining / 20;
            System.out.println("Dispensing " + num20 + " $20 bill(s)");
            remaining %= 20;
        }
        
        if (remaining >= 10) {
            int num10 = remaining / 10;
            System.out.println("Dispensing " + num10 + " $10 bill(s)");
            remaining %= 10;
        }
        
        if (remaining >= 5) {
            int num5 = remaining / 5;
            System.out.println("Dispensing " + num5 + " $5 bill(s)");
            remaining %= 5;
        }
        
        if (remaining >= 1) {
            System.out.println("Dispensing " + remaining + " $1 bill(s)");
        }
    }
}
```
 
---
<h2 style="font-weight:bold;">Problems with this approach:</h2>
<span style="font-weight:bold;">Rigid Structure</span>: The dispensing logic is hardcoded and difficult to modify

<span style="font-weight:bold;">Violation of Single Responsibility</span>: One class handles all denomination logic

<span style="font-weight:bold;">Poor Extensibility</span>: Adding new denominations requires modifying existing code

<span style="font-weight:bold;">Tight Coupling</span>: The ATM system is tightly coupled to specific denomination handling

---

<h2 style="font-weight:bold;"> Definition</h2>
The Chain of Responsibility pattern is a behavioral design pattern that passes requests along a chain of handlers. Each handler processes a specific part of the request and passes the remainder to the next handler in the chain.

<h2 style="font-weight:bold;">Key Characteristics:</h2>
<span style="font-weight:bold;">Sequential Processing</span>: Each handler processes its specific denomination.

<span style="font-weight:bold;">Loose Coupling</span>: Handlers are independent and only know about the next handler.

<span style="font-weight:bold;">Flexible Configuration</span>: The chain can be easily reconfigured.

<span style="font-weight:bold;">Graceful Degradation</span>: If a handler can't process the full amount, it passes the remainder.

---
<h2 style="font-weight:bold;">Solution Structure</h2>
The Chain of Responsibility pattern solves these problems by:

1. Creating a chain of denomination handlers

2. Each handler processes its specific bill type

3. Passing remaining amount to the next handler

4. Allowing dynamic reconfiguration of the chain








<h2 style="font-weight:bold;"> Key Components</h2>
<span style="font-weight:bold;">1. DispenseHandler (Interface)</span>
Role: Defines the contract for all denomination handlers

Responsibility: Declares methods for setting next handler and dispensing cash

Key Methods: setNextHandler(), dispense()

<span style="font-weight:bold;">2. Concrete Handlers (FiftyDollarHandler, TwentyDollarHandler, etc.)</span>
Role: Implements specific denomination handling logic

Responsibility: Processes its denomination and passes remainder to next handler

Key Methods: Overrides dispense() method

<span style="font-weight:bold;">3. ATM (Client)</span>
Role: Initiates the cash dispensing process

Responsibility: Creates and configures the chain of handlers

Key Methods: withdraw(), setupDispenseChain()

---
<h2 style="font-weight:bold;"> Benefits of This Implementation</h2>
<span style="font-weight:bold;">Flexible Denomination Handling</span>: Easy to add, remove, or reorder denominations

<span style="font-weight:bold;">Single Responsibility</span>: Each handler focuses on one denomination

<span style="font-weight:bold;">Open/Closed Principle</span>: New denominations can be added without modifying existing code

<span style="font-weight:bold;">Reusable Components</span>: Handlers can be reused in different ATM configurations

<span style="font-weight:bold;">Maintainable Code</span>: Each handler's logic is isolated and easy to understand


