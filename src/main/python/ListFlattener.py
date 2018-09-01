def main():
    to_flat = [1, "string", ["hello", "world"], -2, ["nested", ["array", ["because"], ["why", ["not"]]]]]
    print(flat(to_flat))

def flat(to_flat):
    result = []
    for element in to_flat:
        if is_iterable(element):
            if isinstance(element, str):
                result.append(element)
            else:
                childElements = flat(element)
                for child in childElements:
                    result.append(child)
        else:
            result.append(element)
    
    return result

def is_iterable(var):
    try:
        a = iter(var)
        return True
    except TypeError as te:
        return False

if __name__ == "__main__":
    main()