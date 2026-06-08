class TextProcessor:

    def format_text(self, *txts: str) -> str:
        if len(txts) == 1:
            return txts[0].upper()
        return "".join(txts)


# Don't modify the code below
processor = TextProcessor()
print(processor.format_text("hello"))
print(processor.format_text("hello", "world"))
