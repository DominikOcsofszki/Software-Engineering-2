#!/bin/sh
#
#
#!/bin/bash

while IFS= read -r line; do
   
zsh _vaadin_script.sh $line
done < "$1"
