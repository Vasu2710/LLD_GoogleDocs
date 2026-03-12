Document can have different types of content = Text, Link, Image.
User can have permission - VIEW, EDIT.


Multiple users can edit simultaneously
Each user has a cursor position
Other users can see cursor updates
Document updates should notify all active collaborators

For an LLD interview, we usually implement:

Observer Pattern → notify users of changes

Cursor tracking per user

Edit operations

(We don't implement full Operational Transformation / CRDT, just simulate collaboration.)
