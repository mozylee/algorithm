import sys
import re


def resolve_main(html):
    return html[6:-7]


def resolve_div(html):
    div_list = list()
    tag, line, title = "", "", ""
    for c in html:
        if c == "<":
            tag = "<"
        elif c == ">":
            tag += ">"
            if tag.startswith("<div"):
                title = tag[12:-2]
            elif tag.startswith("</div>"):
                div_list.append((title, line))
                line = ""
            else:
                line += tag
            tag = ""
        else:
            if len(tag) > 0:
                tag += c
            else:
                line += c
    return div_list


def resolve_p(div):
    p_list = list()
    tag, line = "", ""
    for c in div:
        if c == "<":
            tag = "<"
        elif c == ">":
            tag += ">"
            if tag.startswith("<p>"):
                pass
            elif tag.startswith("</p>"):
                p_list.append(line)
                line = ""
            else:
                line += tag
            tag = ""
        else:
            if len(tag) > 0:
                tag += c
            else:
                line += c
    return p_list


def resolve_line(p):
    regex = re.compile("<[\w/ ]{1,}>")
    p = regex.sub("", p)
    p = p.strip()
    regex2 = re.compile("[ ]{2,}")
    p = regex2.sub(" ", p)
    return p


read = sys.stdin.readline

div = resolve_main(read().rstrip())
for title, div in resolve_div(div):
    print(f"title : {title}")
    p_list = resolve_p(div)
    for line in p_list:
        print(resolve_line(line))
