## Welcome to the AddonTemplate

> This is the README.md file, and it'll probably be the first thing that people see when they try to find your addon on GitHub.
> 
> This file is entirely up to you! You can keep it as concise or as length as you'd like. Generally, it's not a bad idea to keep it fairly concise here, and then link to a wiki (which you can set up for the repository) or other files.

## Some information about this template

This template includes some very basic, example syntax elements, as well as some pretty popular utility features that can be a bit of a hassle setting up if it's your first time.
They'll be listed just below, but have a look around the repository to explore these in a bit more detail!

- **Update checker** - This template comes equipped with an update checker, which saves you the hassle of setting one up. The one being used is from SkBee, and lets the user know if an update is available in console, when the addon is loaded.
  - This will throw a warning in the console if there is no release for the addon yet, but don't worry, once a release is pushed, it should be good to go.
- **Log method** - A utility method to log coloured text to the console, with a prefix, in the same format as you might be used to with Skript colour codes.
- **Some basic syntax elements** - There are a few syntax included in this addon. There is an example of an `Effect`, a `SimpleExpression`, a `PropertyExpression`, a `SimplePropertyExpression`, a `PropertyCondtion`, and a custom `Type`.
  - These are all really basic implementations, and more will be added in the future (event and section examples, etc.)!

## Some Skript information

If you're trying to develop an addon, then I'd assume you at least know what Skript is, and have used it as a language for at least a little while.
It's definitely best to have an understanding of what it is you're developing an addon for, after all.

### Syntax elements

Skript has a bunch of these. They're listed below, with a very, very brief explanation of what they are.
- **Structures**: The top-level syntax, that all code has to be put inside of. See the command structure as an example. These are not generally implemented by addons.
- **Sections**: A syntax element which can have other syntax inside it. Some sections allow for any syntax (effects, more sections, etc.) inside, and others use entries.
- **Effects**: Syntax that makes something happen in Skript. For example, the `spawn` effect makes something spawn.
- **Expressions**: Gettable, and sometimes settable and deletable, elements.
- **Conditions**: Something that returns true or false.
- **Types**: A custom type that users can use in other syntax, where defined.
- **Events**: These are structures, which get executed when the respective event occurs. For example, an `on chat` event will execute the code inside it when a player sends a chat.
- **Functions**: Often used similarly to expressions in Skript, these return a value based on a set of parameters.

### Parse time

Parse time refers to the phase when scripts are loaded, parsed, and checked for correctness.
This is the only time that you should throw errors if anything is out of the ordinary.
The `init` method is called during this phase, and should return true if the syntax is good to go.
With that being said, you can't discern the type of an expression in this phase, and generally best practice is to just silently fail in the `execute` method later if some objects aren't of the right type, or anything else is off.

## Other resources

There are a bunch of great resources out there to help with addon development. The Discord server is always a decent shout if you need some help and can't find an answer elsewhere.

Here's a list of other places you can look before that though:
- [**Mr Darth's syntax cheatsheet**](https://github.com/Mr-Darth/Skriptness/blob/master/learning/syntax-cheatsheet.md) - This is easily the best place to go if you're wondering how Skript syntax works. It goes stuff like how bracketing works, how expressions in patterns work, and how parse tags work.
- [**Pattern calculator**](https://bi0qaw.github.io/skript-pattern-calculator/) - This website allows you to input a pattern, and it'll tell you all the potential patterns that users could use for that syntax element.
- [**The Discord server**](https://discord.gg/skript) - The official skUnity Discord server. This is a great server, with a great community. Just keep in mind that skUnity and the SkriptLang team aren't related.
- **Any maintained, up-to-date addon** - There's no link for this one, because there'd be too many addons to list. That being said, some especially great ones to have a look at and support are [SkBee](https://github.com/ShaneBeee/SkBee), [Lusk](https://github.com/JakeGBLP/Lusk), and [skript-gui](https://github.com/APickledWalrus/skript-gui)!