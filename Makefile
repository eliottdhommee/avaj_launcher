# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: edhommee <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2022/03/04 12:27:37 by edhommee          #+#    #+#              #
#    Updated: 2022/03/17 11:58:02 by edhommee         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #


BIN_DIR	= ./bin/
SRC_DIR	= ./srcs/
FILE	= sources.txt
MAIN	= avaj_launcher/Simulation
ARG		= scenario.txt

all: bins

bins: $(BIN_DIR) $(FILE)
	javac @$(FILE) -d $(BIN_DIR)

$(BIN_DIR):
	@mkdir -p $(BIN_DIR)

$(FILE):
	find $(SRC_DIR)* -name "*.java" > $(FILE)

run: bins
	java -classpath $(BIN_DIR) $(MAIN) $(ARG)

re: clean all

clean:
	@rm -rf $(BIN_DIR)
	@rm -rf $(FILE)
