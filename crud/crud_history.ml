(* CRUD functions for managing player's name and history in CSV *)

(* load_csv: string -> string list list *)
let load_csv filename : string list list =
  Csv.load ~separator:',' filename

(* save_csv: string -> string list list -> unit *)
let save_csv filename (data : string list list) =
  Csv.save ~separator:',' ~quote_all:true filename data

(* find_player_index: string -> string list list -> int option *)
let find_player_index player_name data =
  let rec find_index_helper idx = function
    | [] -> None
    | row :: rest ->
        if List.hd row = player_name then Some idx
        else find_index_helper (idx + 1) rest
  in
  find_index_helper 0 data

(* add_player: string -> string list list -> string list list *)
let add_player player_name data =
  if List.mem player_name (List.map List.hd data) then
    data
  else
    [player_name] :: List.map (fun row -> "" :: row) data

(* update_player: string -> string list list -> string list list *)
let update_player player_name new_history data =
  match find_player_index player_name data with
  | Some idx ->
      let updated_row = player_name :: new_history in
      List.mapi (fun i row -> if i = idx then updated_row else row) data
  | None -> add_player player_name data

(* delete_player: string -> string list list -> string list list *)
let delete_player player_name data =
  match find_player_index player_name data with
  | Some idx -> List.filter (fun _ -> true) (List.mapi (fun i row -> if i = idx then [] else row) data)
  | None -> data

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