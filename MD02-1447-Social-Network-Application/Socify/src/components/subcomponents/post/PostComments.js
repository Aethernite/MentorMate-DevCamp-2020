import React from 'react';
import styled from 'styled-components';
import { useSelector, useDispatch } from 'react-redux';
import { Spinner } from 'react-bootstrap';
import Comment from '../../Comment';
import CommentsForm from '../comment/CommentsForm';
import { fetchCommentsForPost } from '../../../store/slices/comments';

const LoadMore = styled.span`
font-family: 'Roboto', sans-serif;
font-style: italic;
font-weight: 300;
transition: transform 0.2s;
&:hover{
    transform: scale(1.2);
    cursor:pointer;
}
`;

function PostComments({ post, shown }) {

    const dispatch = useDispatch();
    const commentsState = useSelector((state) => state.comments[post.id]);
    const comments = commentsState?.data || [];
    const isLoading = commentsState?.isLoading ?? false;
    const cursor = commentsState?.cursor;
    const hasMoreComments =
        (!comments.length && !!post.commentsCount) || !!(comments.length && cursor);
    return (
        <div style={{ display: shown ? '' : 'none' }}>
            {comments.map((comment) => {
                return <Comment comment={comment} />;
            })}
            <Spinner hidden={!isLoading} animation="border" role="status">
                <span className="sr-only">Loading...</span>
            </Spinner>
            {hasMoreComments &&
                <div className="d-flex justify-content-center">
                    <LoadMore onClick={() => dispatch(fetchCommentsForPost(post.id))}>Load more comments..</LoadMore>
                </div>
            }
            <CommentsForm post={post}></CommentsForm>
        </div>
    );
}

export default PostComments;