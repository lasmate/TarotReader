(* CRUD functions for managing player's name and history in CSV *)

(* Load CSV data from a file *)
let load_csv filename : string list list =
  try
    Csv.load ~separator:',' filename
  with Csv.Error err ->
    (* Handle CSV loading errors *)
    print_endline ("CSV loading error: " ^ Csv.string_of_error err);
    exit 1

(* Save CSV data to a file *)
let save_csv filename (data : string list list) =
  try
    Csv.save ~separator:',' ~quote_all:true filename data
  with Csv.Error err ->
    (* Handle CSV saving errors *)
    print_endline ("CSV saving error: " ^ Csv.string_of_error err);
    exit 1

    (* Find the index of a player in the data *)
let find_player_index player_name data =
  let rec find_index_helper index = function
    | [] -> -1
    | row :: rest ->
      if List.mem player_name row then
        index
      else
        find_index_helper (index + 1) rest
  in
  find_index_helper 0 data


(* Add a new player to the data *)
let add_player player_name data =
  let new_player_line = player_name :: List.map (fun _ -> "") (List.hd data) in
  data @ [new_player_line]

(* Update the draw of an existing player *)
let update_player player_name new_history data =
  let player_index = find_player_index player_name data in
  if player_index >= 0 then
    let updated_row = List.mapi (fun i cell ->
      if i = player_index then new_history else cell
    ) (List.hd data) in
    List.mapi (fun i row ->
      if i = player_index then updated_row else row
    ) data
  else
    data

(* Delete a player from the data *)
let delete_player player_name data =
  let player_index = find_player_index player_name data in
  if player_index >= 0 then
    List.filter (fun _ -> true) (List.mapi (fun i row ->
      if i = player_index then [] else row
    ) data)
  else
    data

    (* Add a draw to the first empty column in the player's line *)
let add_draw_to_player player_name new_history data =
  let player_index = find_player_index player_name data in
  if player_index >= 0 then
    List.mapi (fun i row ->
      if i = player_index then
        let updated_row = List.mapi (fun j cell ->
          if cell = "" && j < String.length new_history then
            String.sub new_history j 1
          else
            String.sub cell j 1
        ) row in
        updated_row
      else
        row
    ) data
  else
    data

(* commandline call *)
  let()
  (*Entry point for calls*)
  if Array.lenght Sys.argv < 3 then
    print_endline "Usage: crud_history <command> <args>"
  else
    let command = Sys.argv.(1) in
    let arguments = Array.sub Sys.argv 2 (Array.length Sys.argv - 2) in
    match command with
    | "add" ->
      (* Check if player exists, if yes, update; otherwise, add a new player *)
      let player_name = arguments.(0) in
      let new_history = arguments.(1) in
      let data = load_csv "your_csv_filename.csv" in
      let player_index = find_player_index player_name data in
      (* If player exists, update; otherwise, add a new player *)
      if player_index >= 0 then
        let updated_data = update_player player_name new_history data in
        save_csv "your_csv_filename.csv" updated_data
      else
        let new_data = add_player player_name data in
        save_csv "your_csv_filename.csv" new_data
    | "delete" ->
      (* Delete the player from the data *)
      let player_name = arguments.(0) in
      let data = load_csv "your_csv_filename.csv" in
      let updated_data = delete_player player_name data in
      save_csv "your_csv_filename.csv" updated_data
    | "update" ->
      (* Add the draw to the first empty column in the player's line *)
      let player_name = arguments.(0) in
      let new_history = arguments.(1) in
      let data = load_csv "your_csv_filename.csv" in
      let updated_data = add_draw_to_player player_name new_history data in
      save_csv "your_csv_filename.csv" updated_data
    | _ -> print_endline "Unknown command"